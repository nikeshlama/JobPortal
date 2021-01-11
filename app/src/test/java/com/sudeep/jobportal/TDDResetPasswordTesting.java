package com.sudeep.jobportal;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TDDJobeventtesting {
    @Test
    public void JobeventTestin(){
        FirebaseAuth auth = Mockito.mock(FirebaseAuth.class);
        final Task<Void> mockedAuth = Mockito.mock(Task.class);
        when(auth.sendPasswordResetEmail("sudeeptddtesting@gmail.com"))
                .thenReturn(mockedAuth);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Task<Void> authResult = invocation.getArgument(0,Task.class);
                assertEquals(true,authResult.isSuccessful());
                return null;
            }
        });

    }
}
