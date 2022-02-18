/*
 *     Copyright (C) 2021 Ruby Hartono
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package m.co.rh.id.a_flash_deck.app.provider.command;

import java.util.concurrent.ExecutorService;

import io.reactivex.rxjava3.core.Single;
import m.co.rh.id.a_flash_deck.base.dao.DeckDao;
import m.co.rh.id.a_flash_deck.base.entity.Deck;
import m.co.rh.id.aprovider.Provider;

public class DeckQueryCmd {
    private ExecutorService mExecutorService;
    private DeckDao mDeckDao;

    public DeckQueryCmd(Provider provider) {
        mExecutorService = provider.get(ExecutorService.class);
        mDeckDao = provider.get(DeckDao.class);
    }

    public Single<Integer> countCards(Deck deck) {
        return Single.fromFuture(mExecutorService.submit(() ->
                mDeckDao.countCardByDeckId(deck.id))
        );
    }

    public Single<Deck> getDeckById(long deckId) {
        return Single.fromFuture(mExecutorService.submit(() ->
                mDeckDao.getDeckById(deckId))
        );
    }
}
