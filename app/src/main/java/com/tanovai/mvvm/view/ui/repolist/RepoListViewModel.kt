package com.tanovai.mvvm.view.ui.repolist

import androidx.lifecycle.MutableLiveData
import com.tanovai.mvvm.architecture.BaseViewModel
import com.tanovai.mvvm.model.Item
import com.tanovai.mvvm.model.RepoRepository

class RepoListViewModel: BaseViewModel() {

    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchRepoList() {
        dataLoading.value = true
        RepoRepository.getInstance().getRepoList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                repoListLive.value = response?.items
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }

}