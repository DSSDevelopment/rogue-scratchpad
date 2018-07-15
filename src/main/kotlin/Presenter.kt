package main

import org.codetome.zircon.api.Position
import org.codetome.zircon.api.terminal.Terminal
import org.codetome.zircon.api.builder.TerminalBuilder
import org.codetome.zircon.api.builder.TextCharacterBuilder
import org.codetome.zircon.api.builder.TextImageBuilder
import org.codetome.zircon.api.component.ColorTheme
import org.codetome.zircon.api.graphics.TextImage
import org.codetome.zircon.api.resource.CP437TilesetResource
import org.codetome.zircon.api.resource.ColorThemeResource

class Presenter(val terminal: Terminal) {
    val introScreen = TerminalBuilder.createScreenFor(terminal)
    val gameScreen = TerminalBuilder.createScreenFor(terminal)

    fun intro() {
        val introTheme = ColorThemeResource.ADRIFT_IN_DREAMS.getTheme()
        val introImage = TextImageBuilder.newBuilder()
                .size(terminal.getBoundableSize())
                .filler(TextCharacterBuilder.newBuilder()
                        .foregroundColor(introTheme.getBrightForegroundColor())
                        .backgroundColor(introTheme.getBrightBackgroundColor())
                        .character('~')
                        .build())
                .build()
        introScreen.draw(introImage, Position.DEFAULT_POSITION)
        introScreen.display()
    }
}

