package com.alex3g.anotationsapp.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex3g.anotationsapp.ui.database.NoteDao
import com.alex3g.anotationsapp.ui.database.NoteEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val noteDao: NoteDao
) : ViewModel() {

    private val _noteDetails = MutableStateFlow<NoteEntity?>(null)
    val noteDetails: StateFlow<NoteEntity?> = _noteDetails

    fun fetchNoteDetails(noteId: Int) {
        viewModelScope.launch {
            val note = noteDao.getNoteById(noteId)
            _noteDetails.value = note
        }
    }
}
