from operator import itemgetter


def solution(genres, plays):
    answer = []
    play_list = {}
    genre_index = {}

    index = 0
    for genre, play in zip(genres, plays):
        if genre in play_list:
            play_list[genre] += play
            genre_index[genre].append((index, play))
        else:
            play_list[genre] = play
            genre_index[genre] = [(index, play)]
        index += 1

    sorted_play_list = sorted(play_list.items(), key=lambda x: x[1], reverse=True)

    for genre, _ in sorted_play_list:
        sorted_genre_index = sorted(genre_index[genre], key=itemgetter(1), reverse=True)
        if len(sorted_genre_index) >= 2:
            answer.append(sorted_genre_index[0][0])
            answer.append(sorted_genre_index[1][0])
        else: answer.append(sorted_genre_index[0][0])

    return answer
