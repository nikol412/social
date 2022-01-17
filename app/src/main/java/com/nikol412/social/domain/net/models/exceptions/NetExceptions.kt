package com.nikol412.social.domain.net.models.exceptions

import java.io.IOException

class NoInternetException : IOException("No internet connection")

class ServerException(code: Int, message: String?) :
    IOException("$message; code: $code")
