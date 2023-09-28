public class BubbleDemo {
    public static void main(String[] args) {

        System.out.println("\n===== Welcome to Bubble! =====\n");


        // user @shakespeare
        Bubble shake = new Bubble("(7:^]", "William Shakespeare", "shakespeare", true);
        shake.setDate(new BubbleDate("November", 1, 1611, 3, 37, true));
        String shakeText = "Our revels now are ended. These our actors,\n"
                + "As I foretold you, were all spirits and\n"
                + "Are melted into air, into thin air:\n"
                + "And, like the baseless fabric of this vision,\n"
                + "The cloud-capp'd towers, the gorgeous palaces,\n"
                + "The solemn temples, the great globe itself,\n"
                + "Ye, all which it inherit, shall dissolve...";
        shake.setBText(shakeText);

        // user @fakeShake
        Bubble fakeShake = new Bubble("o_O", "Wilhelm Shakespeare", "fakeShake", false);
        fakeShake.setDate(new BubbleDate("April", 1, 1611, 6, 42, false));
        fakeShake.setBText(shakeText);

        // user @JasonStraffen15
        Bubble jStraffen = new Bubble("(ツ)", "J", "JasonStraffen15", false);
        BubbleDate jsDate = new BubbleDate("Oct", 10, 2018, 2, 18, false);
        jStraffen.setDate(jsDate);
        String jsText = "dude imagine being a bug and accidentally\n"
                + "getting stuck in a car and driving far af away\n"
                + "from everything you know";
        jStraffen.setBText(jsText);


        //user @ArielDumas
        Bubble aDumas = new Bubble("(ಠ_ಠ)", "Ariel Dumas", "ArielDumas", true);
        aDumas.setDate(new BubbleDate("Oct", 11, 2021, 4, 36, false));
        aDumas.setBText("You telling me this foam has memories?");


        shake.plagiarismCheck(fakeShake);
        aDumas.plagiarismCheck(jStraffen);

        System.out.println(shake);
        System.out.println(fakeShake);
        System.out.println(jStraffen);
        System.out.println(aDumas);

        System.out.println("===== End of Bubble feed =====\n");
        System.out.printf("Bubble has shipped a total of %d bubble(s)"
                + " and detected %d fake bubble(s).%n", Bubble.getNumBubbles(), Bubble.getNumFakeBubbles());
    }
}
