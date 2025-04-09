package com.example.mercadolivre.presentation.search.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mercadolivre.MainCoroutineRule
import com.example.mercadolivre.data.model.ProductSearch
import com.example.mercadolivre.domain.usecase.SearchProductUseCase
import com.example.mercadolivre.presentation.search.action.SearchAction
import com.example.mercadolivre.presentation.search.event.SearchEvent
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
class SearchViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var searchProductUseCase: SearchProductUseCase

    private lateinit var viewModel: SearchViewModel

    @Before
    fun setUp() {
        viewModel = SearchViewModel(searchProductUseCase)
    }

    @Test
    fun `when searchProducts is called with query, should emit loading then success state`() = runTest {
        // Given
        val query = "phone"
        val products = listOf(
            ProductSearch("1", "Product 1", 100.0, "url1"),
            ProductSearch("2", "Product 2", 200.0, "url2")
        )

        whenever(searchProductUseCase.invoke(query)).thenReturn(flow {
            emit(products)
        })

        // When
        viewModel.searchProducts(query)

        // Then
        val state = viewModel.state.getOrAwaitValue(this)
        assertFalse(state.isLoading)
        assertFalse(state.isError)
        assertEquals(products, state.searchProducts)
    }

    @Test
    fun `when searchProducts fails, should emit loading then error state`() = runTest {
        // Given
        val query = "phone"
        val errorMessage = "Network error"

        whenever(searchProductUseCase.invoke(query)).thenReturn(flow {
            throw RuntimeException(errorMessage)
        })

        // When
        viewModel.searchProducts(query)

        // Then
        val state = viewModel.state.getOrAwaitValue(this)
        assertFalse(state.isLoading)
        assertTrue(state.isError)
        assertEquals(emptyList<ProductSearch>(), state.searchProducts)
    }

    @Test
    fun `when ShowProductDetails action is called, should emit NavigateToProductDetails event`() = runTest {
        // Given
        val productId = "123"

        // When
        viewModel.onViewAction(SearchAction.ShowProductDetails(productId))

        // Then
        val event = viewModel.events.getOrAwaitValue(this) as SearchEvent.NavigateToProductDetails
        assertEquals(productId, event.productId)
    }

    @Test
    fun `when SearchProduct action is called, should call searchProducts`() = runTest {
        // Given
        val query = "laptop"
        val products = listOf(ProductSearch("1", "Laptop", 999.99, "url"))

        whenever(searchProductUseCase.invoke(query)).thenReturn(flowOf(products))

        // When
        viewModel.onViewAction(SearchAction.SearchProduct(query))

        // Then
        verify(searchProductUseCase).invoke(query)
        val state = viewModel.state.getOrAwaitValue(this)
        assertEquals(products, state.searchProducts)
    }
}