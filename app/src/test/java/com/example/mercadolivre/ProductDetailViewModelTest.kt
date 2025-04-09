package com.example.mercadolivre



import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mercadolivre.MainCoroutineRule
import com.example.mercadolivre.data.model.MockSearchData
import com.example.mercadolivre.domain.model.Product
import com.example.mercadolivre.domain.usecase.GetProductByIdUseCase
import com.example.mercadolivre.navigation.Screen.ProductDetail
import com.example.mercadolivre.presentation.search.action.ProductDetailsAction
import com.example.mercadolivre.presentation.search.event.ProductDetailsEvent
import com.example.mercadolivre.presentation.search.viewmodel.ProductDetailsViewmodel
import com.example.mercadolivre.presentation.state.ProductDetailsViewState
import getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ProductDetailsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var getProductByIdUseCase: GetProductByIdUseCase

    private lateinit var viewModel: ProductDetailsViewmodel

    @Before
    fun setUp() {
        viewModel = ProductDetailsViewmodel(getProductByIdUseCase)
    }

    @Test
    fun `when LoadProduct action is called, should emit loading then success state`() = runTest {
        // Given
        val productId = "MLB5"
        val productDetails = MockSearchData.getProductDetails(productId)

        whenever(getProductByIdUseCase(productId)).thenReturn(flowOf(productDetails))

        // When
        viewModel.onViewAction(ProductDetailsAction.LoadProduct(productId))

        // Then
        val states = mutableListOf<ProductDetailsViewState>()
        viewModel.state.getOrAwaitValue(this).let { states.add(it) }


        val successState = states.last()
        assertFalse(successState.isLoading)
        assertFalse(successState.isError)
        assertEquals(productDetails, successState.productDetails)
    }

    @Test
    fun `when LoadProduct fails, should emit loading then error state`() = runTest {
        // Given
        val productId = "123"
        val errorMessage = "Product not found"

        whenever(getProductByIdUseCase(productId)).thenReturn(flow {
            throw RuntimeException(errorMessage)
        })

        // When
        viewModel.onViewAction(ProductDetailsAction.LoadProduct(productId))

        // Then
        val states = mutableListOf<ProductDetailsViewState>()
        viewModel.state.getOrAwaitValue(this).let { states.add(it) }

        val state = viewModel.state.getOrAwaitValue(this)

        assertFalse(state.isLoading)
        assertTrue(state.isError)
        assertNull(state.productDetails)
    }

    @Test
    fun `when OnBackPressed action is called, should emit OnBackPressed event`() = runTest {
        // Given
        val expectedEvent = ProductDetailsEvent.OnBackPressed

        // When
        viewModel.onViewAction(ProductDetailsAction.OnBackPressed)

        // Then
        val event = viewModel.events.getOrAwaitValue(this)
        assertEquals(expectedEvent, event)
    }


}