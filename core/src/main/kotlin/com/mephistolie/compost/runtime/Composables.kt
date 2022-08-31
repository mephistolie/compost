package com.mephistolie.compost.runtime

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList

/**
 *
 * rememberSaveable() that ready to use with mutable lists. Make sure you understand why you are using it, cause it's
 * very specific scenario. In most cases data should be stored at view model.
 *
 * Copied from
 * [StackOverflow](https://stackoverflow.com/questions/68885154/using-remembersaveable-with-mutablestatelistof),
 * written by
 * [Phil Dukhov](https://stackoverflow.com/users/3585796/phil-dukhov)
 *
 * @author Phil Dukhov
 * @param T type of list element
 * @param elements vararg elements of mutable list
 */
@Suppress("FunctionMaxLength")
@Composable
fun <T: Any> rememberSaveableMutableStateListOf(vararg elements: T): SnapshotStateList<T> {
    return rememberSaveable(
        saver = listSaver(
            save = { stateList ->
                if (stateList.isNotEmpty()) {
                    val first = stateList.first()
                    if (!canBeSaved(first)) {
                        throw IllegalStateException("${first::class} cannot be saved. By default only types which " +
                                "can be stored in the Bundle class can be saved.")
                    }
                }
                stateList.toList()
            },
            restore = { it.toMutableStateList() }
        )
    ) {
        elements.toList().toMutableStateList()
    }
}

/**
 *
 * rememberSaveable() that ready to use with mutable lists. Make sure you understand why you are using it, cause it's
 * very specific scenario. In most cases data should be stored at view model.
 *
 * Copied from
 * [StackOverflow](https://stackoverflow.com/questions/68885154/using-remembersaveable-with-mutablestatelistof),
 * written by
 * [Phil Dukhov](https://stackoverflow.com/users/3585796/phil-dukhov)
 *
 * @author Phil Dukhov
 * @param T type of list element
 * @param list mutable list of elements
 */
@Suppress("FunctionMaxLength")
@Composable
inline fun <reified T: Any> rememberSaveableMutableStateListOf(list: MutableList<T>) =
    rememberSaveableMutableStateListOf(list.map { it }.toTypedArray())
