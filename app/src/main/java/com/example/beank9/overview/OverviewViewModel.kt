package com.example.beank9.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beank9.network.FeedPhoto
import com.example.beank9.network.PhotoApi
import kotlinx.coroutines.launch

enum class PhotoApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<PhotoApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<PhotoApiStatus> = _status

    private val _photos = MutableLiveData<List<FeedPhoto>>()

    val photos: LiveData<List<FeedPhoto>> = _photos


    /**
     * Call getCameraPhotos() on init so we can display status immediately.
     */
    init {
        getCameraPhotos()
    }

    private fun getCameraPhotos() {

        viewModelScope.launch {
            _status.value = PhotoApiStatus.LOADING
            try {
                _photos.value = PhotoApi.retrofitService.getPhotos()
                _status.value = PhotoApiStatus.DONE
            } catch (e: Exception) {
                _status.value = PhotoApiStatus.ERROR
                _photos.value = listOf()
            }
        }
    }
}

