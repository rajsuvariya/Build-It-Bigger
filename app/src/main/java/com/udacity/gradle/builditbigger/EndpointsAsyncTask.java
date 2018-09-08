package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.test.mock.MockContext;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.rajsuvariya.joketeller.JokeTellerActivity;
import com.udacity.gradle.builditbigger.backend.jokesapi.Jokesapi;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Created by @raj on 28/08/18.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static Jokesapi myApiService = null;
    private Callback mCallback;

    public EndpointsAsyncTask(Callback callback) {
        mCallback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            Jokesapi.Builder builder = new Jokesapi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-9099809050.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        if (mCallback!=null) {
            mCallback.onFinished(joke);
        }
    }

    public interface Callback {
        void onFinished(String joke);
    }
}