package main

import org.codetome.zircon.api.Size
import org.codetome.zircon.api.builder.TerminalBuilder
import org.codetome.zircon.api.builder.DeviceConfigurationBuilder
import org.codetome.zircon.api.resource.CP437TilesetResource
import org.codetome.zircon.api.color.ANSITextColor
import org.codetome.zircon.api.terminal.Terminal
import org.codetome.zircon.api.terminal.config.CursorStyle

fun main(args: Array<String>){
    val text = "HELLO, Zircon!"
    val terminal: Terminal = TerminalBuilder.newBuilder()
            .initialTerminalSize(Size.of(80, 40))
            .font(CP437TilesetResource.WANDERLUST_16X16.toFont())
            .title(text)
            .build()

    terminal.flush()

    terminal.setForegroundColor(ANSITextColor.GREEN)
    terminal.setCursorVisibility(true)
    text.toCharArray().forEach{ c -> terminal.putCharacter(c) }
    terminal.flush()

    val presenter = Presenter(terminal)
    presenter.intro()
}

