package com.zkuzan.basicrxjavasample.ui

import androidx.lifecycle.ViewModel
import com.zkuzan.basicrxjavasample.presistence.User
import com.zkuzan.basicrxjavasample.presistence.UserDAO
import io.reactivex.Completable
import io.reactivex.Flowable

class UserViewModel(private val dataSource: UserDAO) : ViewModel() {


    /**
     * Get the user name of the user.
     * @return a [Flowable] that will emit every time the user name has been updated.
     */
    // for every emission of the user, get the user name
    fun userName(): Flowable<String> {
        return dataSource.getUserById(USER_ID)
            .map { user -> user.userName }

    }

    /**
     * Update the user name.
     * @param userName the new user name
     * *
     * @return a [Completable] that completes when the user name is updated
     */
    fun updateUserName(userName: String): Completable {
        val user = User(USER_ID, userName)
        return dataSource.insertUser(user)
    }


    companion object {
        const val USER_ID = "1"
    }
}