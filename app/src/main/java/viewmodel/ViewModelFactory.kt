package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yoel.roommapviewmodel.data.MarkDao


class ViewModelFactory(private val markDao: MarkDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MarKViewModel::class.java)) {
            return MarKViewModel(markDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}