package com.udacity.gradle.testing;

import android.content.Context;
import android.os.AsyncTask;
import android.support.test.filters.LargeTest;
import android.test.mock.MockContext;
import android.text.TextUtils;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import junit.framework.Assert;

import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by @raj on 29/08/18.
 */

@LargeTest
public class AsyncTaskTest {

    @Test
    public void testJokeApi() throws InterruptedException, ExecutionException, TimeoutException {
        AsyncTask asyncTask = new EndpointsAsyncTask(null).execute();
        String joke = String.valueOf(asyncTask.get(30, TimeUnit.SECONDS));
        Assert.assertEquals(true, !TextUtils.isEmpty(joke));
    }
}
