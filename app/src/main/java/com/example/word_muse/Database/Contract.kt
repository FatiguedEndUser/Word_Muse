package com.example.word_muse.Database

import android.provider.BaseColumns

class Contract {
    object FeedReaderContract{
        object UserEntry: BaseColumns{
            const val TABLE_NAME = "USER"
            const val COLUMN_NAME_USERNAME = "UserName"
            const val COLUMN_NAME_PASSWORD = "Password"
        }

        object FavoriteEntry: BaseColumns{
            const val TABLE_NAME = "FAVORITE"
            const val COLUMN_NAME_WORD = "Word"
        }
    }


}