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

package m.co.rh.id.a_flash_deck.bot.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import m.co.rh.id.a_flash_deck.base.room.converter.Converter;

@Entity(tableName = "suggested_card")
public class SuggestedCard {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo(name = "card_id")
    public Long cardId;

    @TypeConverters({Converter.class})
    @ColumnInfo(name = "created_date_time")
    public Date createdDateTime;

    public SuggestedCard() {
        createdDateTime = new Date();
    }
}
