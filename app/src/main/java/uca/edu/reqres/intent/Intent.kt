package uca.edu.reqres.intent

sealed class Intent {
    object GetReqresEvent: Intent()
    object None: Intent()
}