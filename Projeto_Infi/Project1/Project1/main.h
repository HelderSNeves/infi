#pragma once
#include <vector>
using namespace std;
#include <stdio.h>

#include <opc/ua/client/client.h>
#include <opc/ua/node.h>
#include <opc/ua/subscription.h>

#include <opc/common/logger.h>

#include <iostream>
#include <stdexcept>
#include <thread>

#include"client_order.h"
#include"conveyor_belt.h"
#include"machine.h"
#include"piece.h"