package com.example.mercadolivre.di

import com.example.mercadolivre.presentation.search.viewmodel.ProductDetailsViewmodel
import com.example.mercadolivre.presentation.search.viewmodel.ResultViewmodel
import com.example.mercadolivre.presentation.search.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//val repositoryModule = module {
//    single<ProductRepository> { ProductRepositoryImpl(get()) }
//}
//
//val useCaseModule = module {
//    factory { SearchProductsUseCase(get()) }
//    factory { GetProductDetailsUseCase(get()) }
//}

val viewModelModule = module {
    viewModel { SearchViewModel() }
    viewModel { ResultViewmodel() }
    viewModel { ProductDetailsViewmodel() }
}
