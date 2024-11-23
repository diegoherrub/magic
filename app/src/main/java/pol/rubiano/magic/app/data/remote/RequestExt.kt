package pol.rubiano.magic.app.data.remote

import com.google.gson.JsonParseException
import pol.rubiano.magic.app.domain.ErrorApp
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): Result<T> {
    val response: Response<T>
    try {
        response = call.invoke()
    } catch (exception: Throwable) {
        return when (exception) {
            is ConnectException -> Result.failure(ErrorApp.InternetErrorApp)
            is SocketTimeoutException -> Result.failure(ErrorApp.InternetErrorApp)
            is UnknownHostException -> Result.failure(ErrorApp.ServerErrorApp)
            is JsonParseException -> Result.failure(ErrorApp.DataErrorApp)
            else -> Result.failure(ErrorApp.UnknowErrorApp)
        }
    }
    return if (response.isSuccessful && response.body() != null) {
        Result.success(response.body()!!)
    } else {
        Result.failure(ErrorApp.UnknowErrorApp)
    }
}