package com.codeinger.moviestack.api.repo.trending

import android.util.Log
import com.codeinger.moviestack.pojo.MovieList
import com.codeinger.moviestack.pojo.SmallItemList
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrendingRepository(val trendingRequest: TrendingRequest): TrendingRepositoryI{
    override fun getSmallItemsList(type: SmallItemList.Type): Observable<SmallItemList> {
        return Observable.create<SmallItemList> { emitter ->

            var call : Call<SmallItemList>?

            when(type){
                SmallItemList.Type.TRENDING_MOVIES -> call = trendingRequest?.getTrendingMovies()
                SmallItemList.Type.TRENDING_TV_SHOW -> call = trendingRequest?.getTrendingTvShow()
                SmallItemList.Type.TRENDING_PERSON -> call = trendingRequest?.getTrendingPerson()
                else -> call = trendingRequest?.getTrendingMovies()
            }

            call?.enqueue(object : Callback<SmallItemList> {
                override fun onResponse(call: Call<SmallItemList>, response: Response<SmallItemList>) {
                    Log.i("dsjcvhdbsjchbs","1 "+response.toString())
                    Log.i("dsjcvhdbsjchbs","2 "+call.toString())
                    response.body()?.let {
                        it.type = type
                        emitter.onNext(it)
                        emitter.onComplete()
                    } ?: run {
                        emitter.onNext(SmallItemList())
                        emitter.onComplete()
                    }
                }

                override fun onFailure(call: Call<SmallItemList>, t: Throwable) {
                    Log.i("dsjcvhdbsjchbs","3 "+t.toString())
                    Log.i("dsjcvhdbsjchbs","3 "+call.toString())
                    emitter.onError(t)
                }
            })
        }
    }

    override fun getMoviesList(page: String, type: SmallItemList.Type): Observable<MovieList> {
       return Observable.create<MovieList> { emitter ->

                var call : Call<MovieList>?

                when(type){
                    SmallItemList.Type.TRENDING_MOVIES -> call = trendingRequest?.getTrendingMovies(page)
                    SmallItemList.Type.TRENDING_TV_SHOW -> call = trendingRequest?.getTrendingTvShow(page)
                    SmallItemList.Type.TRENDING_PERSON -> call = trendingRequest?.getTrendingPerson(page)
                    else -> call = trendingRequest?.getTrendingMovies(page)
                }

                call?.enqueue(object : Callback<MovieList>  {

                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {

                        Log.i("dsjcvhdbsjchbs","1 "+response.toString())
                        Log.i("dsjcvhdbsjchbs","2 "+call.toString())
                        response.body()?.let {
                            emitter.onNext(it)
                            emitter.onComplete()
                        } ?: run {
                            emitter.onNext(MovieList())
                            emitter.onComplete()
                        }
                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {
                        Log.i("dsjcvhdbsjchbs","3 "+t.toString())
                        emitter.onError(t)
                    }

                })
            }


    }
}