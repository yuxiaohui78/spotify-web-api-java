package com.wrapper.spotify.requests.data.follow;

import com.wrapper.spotify.ITest;
import com.wrapper.spotify.TestUtil;
import com.wrapper.spotify.enums.ModelObjectType;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CheckCurrentUserFollowsArtistsOrUsersRequestTest implements ITest<Boolean[]> {
  private final CheckCurrentUserFollowsArtistsOrUsersRequest defaultRequest = SPOTIFY_API
          .checkCurrentUserFollowsArtistsOrUsers(ModelObjectType.ARTIST, new String[]{"id"})
          .setHttpManager(
                  TestUtil.MockedHttpManager.returningJson(
                          "requests/data/follow/CheckCurrentUserFollowsArtistsOrUsersRequest.json"))
          .build();

  public CheckCurrentUserFollowsArtistsOrUsersRequestTest() throws Exception {
  }

  @Test
  public void shouldReturnDefault_sync() throws IOException, SpotifyWebApiException {
    shouldReturnDefault(defaultRequest.execute());
  }

  @Test
  public void shouldReturnDefault_async() throws ExecutionException, InterruptedException {
    shouldReturnDefault((Boolean[]) defaultRequest.executeAsync().get());
  }

  public void shouldReturnDefault(final Boolean[] booleans) {
    assertEquals(
            2,
            booleans.length);
  }
}
