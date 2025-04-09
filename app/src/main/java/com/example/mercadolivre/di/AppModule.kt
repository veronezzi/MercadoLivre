package com.example.mercadolivre.di

import com.example.mercadolivre.data.remote.RetrofitClient
import com.example.mercadolivre.data.repository.ProductDetailRepository
import com.example.mercadolivre.data.repository.ProductDetailrepositoryImpl
import com.example.mercadolivre.data.repository.SearchRepository
import com.example.mercadolivre.data.repository.SearchRepositoryImpl
import com.example.mercadolivre.domain.usecase.GetProductByIdUseCase
import com.example.mercadolivre.domain.usecase.SearchProductUseCase
import com.example.mercadolivre.presentation.search.viewmodel.ProductDetailsViewmodel
import com.example.mercadolivre.presentation.search.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitClient.api }
}

val repositoryModule = module {
    single<SearchRepository> { SearchRepositoryImpl(get()) }
    single<ProductDetailRepository> { ProductDetailrepositoryImpl(get()) }
}

val useCaseModule = module {
    factory { GetProductByIdUseCase(get()) }
    factory { SearchProductUseCase(get()) }
}

val viewModelModule = module {
    viewModel { SearchViewModel(get(),get()) }
    viewModel { ProductDetailsViewmodel(get(),get()) }
}
