package com.example.mercadolivre.di

import com.example.mercadolivre.data.remote.RetrofitClient
import com.example.mercadolivre.data.repository.ProductRepository
import com.example.mercadolivre.data.repository.ProductRepositoryImpl
import com.example.mercadolivre.domain.usecase.GetProductByIdUseCase
import com.example.mercadolivre.presentation.results.viewmodel.ResultsViewModel
import com.example.mercadolivre.presentation.search.viewmodel.ProductDetailsViewmodel
import com.example.mercadolivre.presentation.search.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitClient.api }
}

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get()) }
}

val useCaseModule = module {
    factory { GetProductByIdUseCase(get()) }
}

val viewModelModule = module {
    viewModel { SearchViewModel() }
    viewModel { ResultsViewModel(get()) }
    viewModel { ProductDetailsViewmodel(get()) }
}
