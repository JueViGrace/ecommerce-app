package com.clo.closs.presentation.main.events

sealed class SearchEvent {
    data class SearchQuery(val query: String) : SearchEvent()
}
