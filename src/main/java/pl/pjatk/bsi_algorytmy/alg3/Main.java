package pl.pjatk.bsi_algorytmy.alg3;
/*
    exercise 4
    https://pejot.sharepoint.com/sites/2021D_GIs_BIS-501c/Shared%20Documents/Forms/AllItems.aspx?id=%2Fsites%2F2021D%5FGIs%5FBIS%2D501c%2FShared%20Documents%2FGeneral%2Freliability%2Epdf&parent=%2Fsites%2F2021D%5FGIs%5FBIS%2D501c%2FShared%20Documents%2FGeneral&p=true&originalPath=aHR0cHM6Ly9wZWpvdC5zaGFyZXBvaW50LmNvbS86Yjovcy8yMDIxRF9HSXNfQklTLTUwMWMvRVRUVllkN0FfbUJKdEd5bFRQMkhkVXdCV3hFUldPdVZrZ252SXVJMkFzcDREQT9ydGltZT12UzZMa2VLQTJFZw
*/

class Main {
    public static void main(String[] args) {
        int hours = 5000;
        float percentage = 0.98f;
        System.out.format("%.8f",Math.log(percentage)/hours * -1);
    }
}