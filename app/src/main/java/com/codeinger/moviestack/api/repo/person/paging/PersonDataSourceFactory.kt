package com.codeinger.moviestack.api.repo.person.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.codeinger.moviestack.pojo.Result
import com.codeinger.moviestack.api.repo.person.PersonRepositoryI
import io.reactivex.disposables.CompositeDisposable

class PersonDataSourceFactory (var compositeDisposable: CompositeDisposable,
                               var personRepositoryI: PersonRepositoryI
): DataSource.Factory<Int, Result>()  {


    val moviesLiveDataSource =  MutableLiveData<PersonDataSource>()

    override fun create(): DataSource<Int, Result> {
        val personDataSource =
            PersonDataSource(
                compositeDisposable,
                personRepositoryI
            )
        moviesLiveDataSource.postValue(personDataSource)
        return personDataSource
    }

}