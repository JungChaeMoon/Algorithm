class Node(object):

    def __init__(self, time, weight):
        self.stay = time
        self.weight = weight

    def plus_time(self):
        self.stay += 1


def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = []
    complete = []
    init_truck = truck_weights.copy()

    bridge_weight = 0
    while complete != init_truck:
        for truck in bridge:
            truck.plus_time()

        if bridge and bridge[0].stay == bridge_length:
            bridge_weight -= bridge[0].weight
            complete.append(bridge.pop(0).weight)

        if truck_weights:
            bridge_weight += truck_weights[0]
            if bridge_weight <= weight:
                bridge.append(Node(0, truck_weights.pop(0)))

            else:
                bridge_weight -= truck_weights[0]

        answer += 1

    return answer
