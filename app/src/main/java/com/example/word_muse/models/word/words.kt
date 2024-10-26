//

package com.example.word_muse.models.word

data class words(var word: String,
                 var phonetic: String,
                 var phonetics: List<Phonetics>,
                 var origin: String,
                 var meaning: String,
                 )