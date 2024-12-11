package viewmodel

import androidx.lifecycle.ViewModel
import com.yoel.roommapviewmodel.data.MarkDao
import com.yoel.roommapviewmodel.data.MarkWithTypeMark
import kotlinx.coroutines.flow.Flow

class MarKViewModel(private val markDao: MarkDao) : ViewModel() {

    val marksWithTypes: Flow<List<MarkWithTypeMark>> =
        markDao.getAllMarksAndTypes()
}