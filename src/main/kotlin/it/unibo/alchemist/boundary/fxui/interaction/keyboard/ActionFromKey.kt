/*
 * Copyright (C) 2010-2023, Danilo Pianini and contributors
 * listed, for each module, in the respective subproject's build.gradle.kts file.
 *
 * This file is part of Alchemist, and is distributed under the terms of the
 * GNU General Public License, with a linking exception,
 * as described in the file LICENSE in the Alchemist distribution's top directory.
 */

package it.unibo.alchemist.boundary.fxui.interaction.keyboard

/**
 * Actions which can be bound to a key on the keyboard.
 */
enum class ActionFromKey(
    private val description: String,
) {
    /**
     * Control modifier.
     */
    MODIFIER_CONTROL("Control modifier"),

    /**
     * Shift modifier.
     */
    MODIFIER_SHIFT("Shift modifier"),

    /**
     * Pan north.
     */
    PAN_NORTH("Pan north"),

    /**
     * Pan south.
     */
    PAN_SOUTH("Pan south"),

    /**
     * Pan east.
     */
    PAN_EAST("Pan east"),

    /**
     * Pan west.
     */
    PAN_WEST("Pan west"),

    /**
     * Deletion.
     */
    DELETE("Delete"),

    /**
     * Move.
     */
    MOVE("Move"),

    /**
     * Edit.
     */
    EDIT("Edit"),

    /**
     * Play and Pause.
     */
    PLAY_AND_PAUSE("Play and Pause"),

    /**
     * Forward one step.
     */
    ONE_STEP("Forward one step"),
    ;

    override fun toString() = description
}
