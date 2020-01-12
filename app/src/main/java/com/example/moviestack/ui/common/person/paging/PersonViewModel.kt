package com.example.moviestack.ui.common.person.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviestack.api.pojo.Result
import com.example.moviestack.api.pojo.SmallItemList
import com.example.moviestack.api.repo.search.SearchRepositoryI
import com.example.moviestack.api.repo.search.searchpaging.SearchDataSource
import com.example.moviestack.api.repo.search.searchpaging.SearchDataSourceFactory
import com.example.moviestack.ui.common.movielist.MovieListState
import io.reactivex.disposables.CompositeDisposable

class PersonViewModel : ViewModel() {

    lateinit var moviePagedList: LiveData<PagedList<Result>>
    lateinit var state : LiveData<MovieListState>
    private val compositeDisposable = CompositeDisposable()

    val config = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPageSize(20)
        .build()

    fun getSearchMovieData(data : String, searchRepositoryI: SearchRepositoryI, type : SmallItemList.Type){
        var searchDataSourceFactory = SearchDataSourceFactory(data,compositeDisposable,searchRepositoryI,type)
        moviePagedList = LivePagedListBuilder(searchDataSourceFactory, config).build()
        state = Transformations.switchMap<SearchDataSource, MovieListState>(
            searchDataSourceFactory.moviesLiveDataSource, SearchDataSource::mutableLiveData)
    }
}