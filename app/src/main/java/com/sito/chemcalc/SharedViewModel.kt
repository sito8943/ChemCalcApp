
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sito.chemcalc.data.local.Repository
import com.sito.chemcalc.data.local.model.Element
import com.sito.chemcalc.data.local.model.Substance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: Repository

) : ViewModel() {

    val allElements = repository.allElements
    val allSubstances = repository.allSubstances

    /*Elements*/
    fun onInsertElement(element: Element) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertElement(element = element)
        }
    }

    fun onUpdateElement(element: Element) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateElement(element = element)
        }
    }

    fun onDeleteElement(element: Element) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteElement(element = element)
        }
    }

    suspend fun onGetElementById(id: Int) = repository.getElementById(id)
    suspend fun onGetElementBySymbol(symbol: String) = repository.getElementBySymbol(symbol)

    /*Substance*/
    fun onInsertSubstance(substance: Substance) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertSubstance(substance = substance)
        }
    }

    fun onUpdateSubstance(substance: Substance) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateSubstance(substance = substance)
        }
    }

    fun onDeleteSubstance(substance: Substance) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteSubstance(substance = substance)
        }
    }

    suspend fun onGetSubstanceById(id: Int) = repository.getElementById(id)
    suspend fun onGetSubstanceByFormula(formula: String) = repository.getSubstanceByFormula(formula)

}