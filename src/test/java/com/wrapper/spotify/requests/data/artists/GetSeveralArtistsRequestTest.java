package com.wrapper.spotify.requests.data.artists;

import com.wrapper.spotify.ITest;
import com.wrapper.spotify.TestUtil;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Artist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GetSeveralArtistsRequestTest implements ITest<Artist[]> {
  private final GetSeveralArtistsRequest defaultRequest = SPOTIFY_API.getSeveralArtists("id")
          .setHttpManager(
                  TestUtil.MockedHttpManager.returningJson(
                          "requests/data/artists/GetSeveralArtistsRequest.json"))
          .build();

  public GetSeveralArtistsRequestTest() throws Exception {
  }

  @Test
  public void shouldReturnDefault_sync() throws IOException, SpotifyWebApiException {
    shouldReturnDefault(defaultRequest.execute());
  }

  @Test
  public void shouldReturnDefault_async() throws ExecutionException, InterruptedException {
    shouldReturnDefault((Artist[]) defaultRequest.executeAsync().get());
  }

  public void shouldReturnDefault(final Artist[] artists) {
    assertEquals(
            2,
            artists.length);
  }
}
