package com.example.beank9.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getCameraPhotos() on init so we can display status immediately.
     */
    init {
        getCameraPhotos()
    }

    private fun getCameraPhotos() {
        _status.value = "Retrieving images from server..."
    }
}

