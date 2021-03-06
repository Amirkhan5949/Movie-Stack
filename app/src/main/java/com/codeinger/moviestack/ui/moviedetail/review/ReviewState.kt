package com.codeinger.moviestack.ui.moviedetail.review

import com.codeinger.moviestack.ui.moviedetail.review.adapter.ReviewAdapter

data class ReviewState (
    var loading: Boolean = false,
    var success: Boolean = false,
    var failure: Boolean = false,
    var message: String? = null,
    var reviewAdapter: ReviewAdapter? = null
)