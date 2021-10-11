package com.sito.chemcalc.di

import android.content.Context
import com.sito.chemcalc.data.local.ChemCalcDb
import com.sito.chemcalc.data.local.Repository
import com.sito.chemcalc.data.local.dao.ElementDao
import com.sito.chemcalc.data.local.dao.SubstanceDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        ChemCalcDb.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideElementDao(database: ChemCalcDb): ElementDao = database.elementDao()

    @Singleton
    @Provides
    fun provideSubstanceDao(database: ChemCalcDb): SubstanceDao = database.substanceDao()

    @Singleton
    @Provides
    fun provideRepository(
        elementDao: ElementDao,
        substanceDao: SubstanceDao
    ) = Repository(elementDao = elementDao, substanceDao = substanceDao)

}