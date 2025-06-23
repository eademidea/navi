package br.com.navi.controller;

import br.com.navi.ChatRequest;
import br.com.navi.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

//@RestController //Usado para API retorna JSON
@Controller // usado para renderizar páginas HTML com Thymeleaf.
public class ChatController {


    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/chat")
    public String chat(Model model) {
        model.addAttribute("chatRequest", new ChatRequest());
        return "chat";
    }

    @PostMapping("/ask")
    public String ask(
            @ModelAttribute ChatRequest request
            , Model model) {

        var resp = chatClient
                .prompt(String.format("""
                                                
                        Antes de qualquer coisa Hoje é dia %s
                                                
                        Você é um assistente teólogo (e deverá responder como um teólogo, com nuances teológicas) e católico e deverá e deverá instruir a cerca do que diz respeito ao evangelho e a  fé católica.
                        A resposta deverá ser em no máximo 150 palavras.

                        Não faça comunicação genérica.

                        A liturgia do dia deverá ser consultada do site: https://liturgia.cancaonova.com/pb/
                        """, LocalDateTime.now()))
                .user(request.getPrompt())
                .call();
        model.addAttribute("chatResponse", new ChatResponse(resp.content()));
        return "chat";
    }

}
