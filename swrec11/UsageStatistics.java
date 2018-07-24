package com.lewisswrec.swrec11;



import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.util.Log;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class UsageStatistics {

        public static final String TAG = com.lewisswrec.swrec11.UsageStatistics.class.getSimpleName();
        @SuppressWarnings("ResourceType")


        public static List<UsageStats> getUsageStatsList(Context context){
            UsageStatsManager useStatsMan = getUsageStatsManager(context);
            Calendar calendar = Calendar.getInstance();
            long endTime = calendar.getTimeInMillis();
            calendar.add(Calendar.YEAR, -1);
            long startTime = calendar.getTimeInMillis();

            List<UsageStats> usageStatsArray = useStatsMan.queryUsageStats(UsageStatsManager.INTERVAL_DAILY,startTime,endTime);
            return usageStatsArray;
        }

        public static void printFacebookStats(List<UsageStats> usageStatArray){
            for (UsageStats use : usageStatArray){

                if(Objects.equals(use.getPackageName(), "com.facebook.katana"))
                {
                    Log.d(TAG,"App Name: " + use.getPackageName() + "\nForeground Time: " + use.getTotalTimeInForeground());
                }

            }

        }

        public static void printMessengerStats(List<UsageStats> usageStatArray){
            for (UsageStats use : usageStatArray){

                if(Objects.equals(use.getPackageName(), "com.facebook.orca"))
                {
                    Log.d(TAG, "App Name: " + use.getPackageName() + "\nForeground Time: " + use.getTotalTimeInForeground());
                }


            }

        }


        public static void printInstaStats(List<UsageStats> usageStatArray){
            for (UsageStats use : usageStatArray){

                if(Objects.equals(use.getPackageName(), "com.instagram.android"))
                {
                    Log.d(TAG, "App Name: " + use.getPackageName() + "\nForeground Time: " + use.getTotalTimeInForeground());
                }


            }

        }

        public static void printTwitterStats(List<UsageStats> usageStatArray){
            for (UsageStats use : usageStatArray){

                if(Objects.equals(use.getPackageName(), "com.twitter.android"))
                {
                    Log.d(TAG, "App Name: " + use.getPackageName() + "\nForeground Time: " + use.getTotalTimeInForeground());
                }


            }

        }

        public static void printSnapchatStats(List<UsageStats> usageStatArray){
            for (UsageStats use : usageStatArray){

                if(Objects.equals(use.getPackageName(), "com.snapchat.android"))
                {
                    Log.d(TAG, "App Name: " + use.getPackageName() + "\nForeground Time: " + use.getTotalTimeInForeground());
                }


            }

        }


        public static void printCurrentUsageStatus(Context context){

            printFacebookStats(getUsageStatsList(context));



        }

        public static void printMessStatus(Context context){

            //if(getUsageStatsList(Context "com.facebook.katana")) {
            printMessengerStats(getUsageStatsList(context));

        }

        public static void printInstaStatus(Context context){

            //if(getUsageStatsList(Context "com.facebook.katana")) {
            printInstaStats(getUsageStatsList(context));

        }

        public static void printTwitterStatus(Context context){

            //if(getUsageStatsList(Context "com.facebook.katana")) {
            printTwitterStats(getUsageStatsList(context));

        }

        public static void printSnapStatus(Context context){

            //if(getUsageStatsList(Context "com.facebook.katana")) {
            printSnapchatStats(getUsageStatsList(context));

        }

        @SuppressWarnings("ResourceType")
        private static UsageStatsManager getUsageStatsManager(Context context){
            UsageStatsManager useStatsMan = (UsageStatsManager) context.getSystemService("usagestats");
            return useStatsMan;
        }


}
