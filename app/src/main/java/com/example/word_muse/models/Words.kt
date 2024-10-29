//

package com.example.word_muse.models

data class Words(var word: String,
                 var phonetic: String,
                 var phonetics: List<Phonetics>,
                 var origin: String,
                 var meaning: String,
                 )

data class Definitions(var definition: String,
                       var example: String,
                       var synonyms: List<String>,
                       var antonyms: List<String>
)

data class Meaning(var partOfSpeech: String,
                   var definitions: List<Definitions>
)

data class Phonetics(
    var text: String,
    var audio: String
)
