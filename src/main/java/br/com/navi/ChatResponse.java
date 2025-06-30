package br.com.navi;

public class ChatResponse {

    private String reply;

    private String classCss;

    public ChatResponse(String reply, String classCss) {
        this.reply = reply;
        this.classCss = classCss;
    }

    public String getClassCss() {
        return classCss;
    }

    public String getReply() {
        return reply;
    }

}