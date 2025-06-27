package br.com.navi.controller;

import br.com.navi.ChatRequest;
import br.com.navi.ChatResponse;
import br.com.navi.Entity.LiturgicalDay;
import br.com.navi.services.LiturgyServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
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

    private final LiturgyServiceImpl liturgyService;

    private LiturgicalDay liturgy;

    public ChatController(@Qualifier("chatClient41nano") ChatClient chatClient
            , LiturgyServiceImpl liturgyService) {
        this.chatClient = chatClient;
        this.liturgyService = liturgyService;
    }

    @Autowired
    ApplicationContext context;

    @PostConstruct
    public void constructInitialParams() {
        liturgy = liturgyService.getLiturgy();
        System.out.println("Beans de ChatClient:");
        String[] beans = context.getBeanNamesForType(ChatClient.class);
        for (String bean : beans) {
            System.out.println(bean);
        }
    }


    @GetMapping("/chat")
    public String chat(Model model) {
        model.addAttribute("chatRequest", new ChatRequest());
        return "chat";
    }

    @PostMapping("/ask")
    public String ask(@ModelAttribute ChatRequest request
            , Model model) {

        var resp = chatClient
                .prompt()
                .system(comportamentoPadrao())
                .user(request.getPrompt())
                .options(ChatOptions.builder()
                        .frequencyPenalty(1d)
                        .temperature(0.8d)
                        .maxTokens(500)
//                        .model("gpt-3.5-turbo")
                        .build())
                .advisors(new SimpleLoggerAdvisor())
                .call();
        model.addAttribute("chatResponse", new ChatResponse(resp.content()));
        model.addAttribute("perguntaRealizada", request.getPrompt());
        return "chat";
    }

    private String comportamentoPadrao() {
        return String.format("""
                Você é um teólogo católico e deverá responder de forma técnica. 
                Sua resposta deverá ser em no máximo 50 palavras.
                                        
                O dia de hoje é dia %s
                                        
                Use uma comunicação jovem, sem formalidade                                            
                                        
                Quando usuário pedir, informe sempre as referencias das repostas.
                                
                Não precisa ter padrão na resposta mas seja coerente com tema.
                                
                Obs: Perguntas sem sentido que fogem o tema não precisa seguir o padrão na resposta, seja cortês mas só responda assuntos relacionados a fé catolica.
                Perguntas sobre o evangelho do dia ou liturgia do dia você deverá usar por OBRIGAÇÃO as seguintes informações:
                                
                """, LocalDateTime.now()).concat(liturgy.toString());
    }

}
