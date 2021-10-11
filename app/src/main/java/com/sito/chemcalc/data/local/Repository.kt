package com.sito.chemcalc.data.local

import com.sito.chemcalc.data.local.dao.ElementDao
import com.sito.chemcalc.data.local.dao.SubstanceDao
import com.sito.chemcalc.data.local.model.Element
import com.sito.chemcalc.data.local.model.Substance
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val elementDao: ElementDao, private val substanceDao: SubstanceDao) {
    val allSubstances: Flow<List<Substance>> = substanceDao.getAllSubstances()
    val allElements: Flow<List<Element>> = elementDao.getAllElements()

    /*Elements*/
    suspend fun insertElement(element: Element) {
        elementDao.insert(element = element)
    }

    suspend fun updateElement(element: Element) {
        elementDao.update(element = element)
    }

    suspend fun deleteElement(element: Element) {
        elementDao.delete(element = element)
    }

    suspend fun getElementById(id: Int) = elementDao.getElementById(id)
    suspend fun getElementBySymbol(symbol: String) = elementDao.getElementBySymbol(symbol)

    /*Substances*/
    suspend fun insertSubstance(substance: Substance) {
        substanceDao.insert(substance = substance)
    }

    suspend fun updateSubstance(substance: Substance) {
        substanceDao.update(substance = substance)
    }

    suspend fun deleteSubstance(substance: Substance) {
        substanceDao.delete(substance = substance)
    }

    suspend fun getSubstanceById(id: Int) = substanceDao.getSubstanceById(id)
    suspend fun getSubstanceByFormula(formula: String) = substanceDao.getSubstanceByFormula(formula)

}