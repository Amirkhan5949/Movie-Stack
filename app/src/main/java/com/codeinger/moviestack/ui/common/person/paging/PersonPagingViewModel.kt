package com.codeinger.moviestack.ui.common.person.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.codeinger.moviestack.pojo.Result
import com.codeinger.moviestack.pojo.SmallItemList
import com.codeinger.moviestack.api.repo.person.PersonRepositoryI
import com.codeinger.moviestack.api.repo.person.paging.PersonDataSource
import com.codeinger.moviestack.api.repo.person.paging.PersonDataSourceFactory
import com.codeinger.moviestack.api.repo.search.SearchRepositoryI
import com.codeinger.moviestack.api.repo.search.paging.SearchDataSource
import com.codeinger.moviestack.api.repo.search.paging.SearchDataSourceFactory
import com.codeinger.moviestack.api.repo.trending.TrendingRepositoryI
import com.codeinger.moviestack.api.repo.trending.paging.TrendingItemDataSource
import com.codeinger.moviestack.api.repo.trending.paging.TrendingItemDataSourceFactory
import com.codeinger.moviestack.ui.common.movielist.MovieListState
import io.reactivex.disposables.CompositeDisposable

class PersonPagingViewModel : ViewModel() {

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

    fun getPopularPersonData(personRepositoryI : PersonRepositoryI){
        var personDataSourceFactory = PersonDataSourceFactory(compositeDisposable,personRepositoryI)
        moviePagedList = LivePagedListBuilder(personDataSourceFactory, config).build()
        state = Transformations.switchMap<PersonDataSource, MovieListState>(
            personDataSourceFactory.moviesLiveDataSource, PersonDataSource::mutableLiveData)
    }

    fun getTrendingData(trendingRepositoryI: TrendingRepositoryI, type : SmallItemList.Type){
        var  trendingItemDataSourceFactory  =
            TrendingItemDataSourceFactory(
                compositeDisposable,
                trendingRepositoryI,
                type
            )
        moviePagedList = LivePagedListBuilder(trendingItemDataSourceFactory, config).build()
        state = Transformations.switchMap<TrendingItemDataSource, MovieListState>(
            trendingItemDataSourceFactory.moviesLiveDataSource, TrendingItemDataSource::mutableLiveData)
    }
}