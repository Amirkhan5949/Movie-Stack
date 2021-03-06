package com.codeinger.moviestack.ui.common.person

import com.codeinger.moviestack.ui.common.person.adapter.PersonAdapter

data class PersonSatate (
    var loading: Boolean = false,
    var success: Boolean = false,
    var failure: Boolean = false,
    var message: String? = null,
    var personAdapter : PersonAdapter? = null
)