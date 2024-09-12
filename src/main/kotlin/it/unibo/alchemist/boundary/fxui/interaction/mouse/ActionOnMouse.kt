/*
 * Copyright (C) 2010-2022, Danilo Pianini and contributors
 * listed, for each module, in the respective subproject's build.gradle.kts file.
 *
 * This file is part of Alchemist, and is distributed under the terms of the
 * GNU General Public License, with a linking exception,
 * as described in the file LICENSE in the Alchemist distribution's top directory.
 */

package it.unibo.alchemist.boundary.fxui.interaction.mouse

/**
 * Actions that can happen on a mouse and a certain mouse button.
 * The enum's values are based on JavaFX's mouse events, such as onMouseClicked:
 * [CLICKED], [DRAGGED], [ENTERED], [EXITED], [MOVED], [PRESSED], [RELEASED].
 */
enum class ActionOnMouse {
    /**
     * The mouse button was clicked.
     */
    CLICKED,

    /**
     * The mouse button was dragged.
     */
    DRAGGED,

    /**
     * The mouse entered the area.
     */
    ENTERED,

    /**
     * The mouse exited the area.
     */
    EXITED,

    /**
     * The mouse was moved.
     */
    MOVED,

    /**
     * The mouse button was pressed.
     */
    PRESSED,

    /**
     * The mouse button was released.
     */
    RELEASED,
}
