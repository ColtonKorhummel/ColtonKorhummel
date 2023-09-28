public class Bubble {
    private String emoticon;
    private String name;
    private String username;
    private boolean verified;
    private String bubbleText;
    private BubbleDate date;
    private static int numBubbles = 0;
    private static int numFakeBubbles = 0;


    public Bubble(String emot, String Tempname, String User, boolean test){
        emoticon = emot;
        name = Tempname;
        username = User;
        verified = test;
    }


     public void setBText(String bubbleText) {
        numBubbles++;
        if(bubbleText.length() > 140 ){
            this.bubbleText = (bubbleText.substring(0, 137) + "...");
        } else {
            this.bubbleText = bubbleText;
        }
     }

    public void setDate(BubbleDate date) {
        this.date = date;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getBubbleText() {
        return bubbleText;
    }


    public String toString() {
        String sign;
        if(isVerified()){
            sign = "\u2713";
        } else {
            sign = " ";
        }
        return (emoticon + " " + name + " " + sign + " @" + username + "\n" + bubbleText + "\n" + date + "\n");

    }

    public BubbleDate getDate() {
        return date;
    }


    public boolean equals(Bubble otherBubble) {
        if(bubbleText.equals(otherBubble.bubbleText)) {
            return true;
        } else {
            return false;
        }
    }

    public static int getNumBubbles() {
        return numBubbles;
    }

    public static int getNumFakeBubbles() {
        return numFakeBubbles;
    }

    public void plagiarismCheck(Bubble otherBubble) {
        if(!bubbleText.equals(otherBubble.bubbleText) || !date.getMonth().equals(otherBubble.date.getMonth())
        || date.getDay()!=otherBubble.date.getDay() || date.getYear()!=otherBubble.date.getYear()){
            return;
        }
        if(date.isAm() && !otherBubble.date.isAm()){
            numBubbles--;
            numFakeBubbles++;
            otherBubble.bubbleText = "[Plagiarism detected. Text removed.]";
        } else if (!date.isAm() && otherBubble.date.isAm()){
            numBubbles--;
            numFakeBubbles++;
            bubbleText = "Plagiarism detected. Text removed.]";
        } else if(date.getHour() < otherBubble.date.getHour()){
            numBubbles--;
            numFakeBubbles++;
            otherBubble.bubbleText = "Plagiarism detected. Text removed.]";
        } else if (date.getHour() > otherBubble.date.getHour()){
            numBubbles--;
            numFakeBubbles++;
            bubbleText = "Plagiarism detected. Text removed.]";
        } else if (date.getMinute() < otherBubble.date.getMinute()){
            numBubbles--;
            numFakeBubbles++;
            otherBubble.bubbleText = "Plagiarism detected. Text removed.]";
        } else if (date.getMinute() > otherBubble.date.getMinute()){
            numBubbles--;
            numFakeBubbles++;
            bubbleText = "Plagiarism detected. Text removed.]";
        }
    }

}
