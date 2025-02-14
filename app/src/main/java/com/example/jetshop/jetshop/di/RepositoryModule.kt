package com.example.jetshop.jetshop.di

import com.example.jetshop.jetshop.data.repository.ProductRepositoryImpl
import com.example.jetshop.jetshop.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideProductsRepository(impl: ProductRepositoryImpl): ProductRepository

}