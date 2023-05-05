package com.example.driftecommerce.di

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.driftecommerce.DriftApplication
import com.example.driftecommerce.data.local.dao.CartDao
import com.example.driftecommerce.data.local.dao.ProductDao
import com.example.driftecommerce.data.local.database.DriftDatabase
import com.example.driftecommerce.data.network.Services
import com.example.driftecommerce.data.repository.CartRepository
import com.example.driftecommerce.data.repository.ProductListRepository
import com.example.driftecommerce.viewmodel.ProductDetailBottomSheetViewModel
import com.example.driftecommerce.viewmodel.ProductListViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.components.ViewComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.android.scopes.ViewScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DriftModule {

    @Singleton
    @Provides
    fun provideMoshiBuilder(): Moshi {
        return Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://api.drift.co.ke/api/test/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
    }

    @Singleton
    @Provides
    fun provideServices(retrofit: Retrofit.Builder): Services  {
        return retrofit.build().create(Services::class.java)
    }


    @Provides
    @Singleton
    fun provideDriftDatabase(@ApplicationContext context: Context): DriftDatabase {
        return Room.databaseBuilder(context, DriftDatabase::class.java, DriftDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCartDao(driftDatabase: DriftDatabase) : CartDao{
        return driftDatabase.cartDao()
    }

    @Provides
    @Singleton
    fun provideProductDao(driftDatabase: DriftDatabase) : ProductDao {
        return driftDatabase.productDao()
    }

    @Provides
    @Singleton
    fun provideProductListRepository(services: Services, productDao: ProductDao) : ProductListRepository {
        return ProductListRepository(productDao, services)
    }

    @Provides
    @Singleton
    fun provideProductListViewModel(productListRepository: ProductListRepository) : ProductListViewModel {
        return ProductListViewModel(productListRepository)
    }

    @Provides
    @Singleton
    fun provideCartRepository(cartDao: CartDao) : CartRepository {
        return CartRepository(cartDao)
    }

    @Provides
    @Singleton
    fun provideProductDetailBottomSheetViewModel(cartRepository: CartRepository) : ProductDetailBottomSheetViewModel {
        return ProductDetailBottomSheetViewModel(cartRepository)
    }
}