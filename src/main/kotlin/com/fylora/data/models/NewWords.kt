package com.fylora.data.models

import com.fylora.util.Constants.TYPE_NEW_WORDS

data class NewWords(
    val newWords: List<String>,
): BaseModel(TYPE_NEW_WORDS)
