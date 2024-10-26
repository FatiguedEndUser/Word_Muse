package com.example.word_muse.models.word

data class Definitions(var definition: String,
                       var example: String,
                        var synonyms: List<String>,
                    var antonyms: List<String>
)
